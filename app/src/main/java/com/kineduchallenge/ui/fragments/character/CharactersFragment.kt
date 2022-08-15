package com.kineduchallenge.ui.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kineduchallenge.characterItem
import com.kineduchallenge.core.database.schema.Character
import com.kineduchallenge.databinding.FragmentCharactersBinding
import com.kineduchallenge.ui.events.OpenCharacterScreen
import com.kineduchallenge.ui.events.ShowListCharacters
import com.kineduchallenge.viewmodel.CharactersViewModel
import com.kineduchallenge.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var mViewBinding: FragmentCharactersBinding? = null
    private val mViewModel: CharactersViewModel by viewModels()
    private val mMainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentCharactersBinding.inflate(inflater, container, false)
        return mViewBinding?.root
    }

    override fun onStart() {
        super.onStart()
        setupWidgets()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewBinding = null
    }

    private fun setupWidgets() {
        mViewModel.consultCharacters()

        mViewModel.mUIEventListener.removeObservers(this)
        mViewModel.mUIEventListener.observe(this) {
            it.getContentIfNotHandled()?.let { event ->
                var eventHandled = true
                when (event) {
                    is ShowListCharacters -> {
                        showListCharacters(event.characters)
                    }
                    else -> eventHandled = false
                }

                if (eventHandled) it.setContentHandled()
            }
        }

    }

    private fun showListCharacters(characters: List<Character>) {
        mViewBinding?.recyclerViewCharacters?.withModels {
            characters.forEach { character ->
                character {
                    id(character.id)
                    character(character)
                    epoxyListener(object : CharacterEpoxyModel.Listener {
                        override fun onCharacterClick(id: Int) {
                            mMainViewModel.postNavigationEvent(OpenCharacterScreen(id))
                        }
                    })
                }
            }
        }
    }

    companion object {
        const val TAG = "characters_screen"

        fun newInstance() = CharactersFragment()
    }

}