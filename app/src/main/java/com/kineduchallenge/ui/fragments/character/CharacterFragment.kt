package com.kineduchallenge.ui.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.kineduchallenge.core.database.schema.Character
import com.kineduchallenge.core.database.schema.Comic
import com.kineduchallenge.databinding.FragmentCharacterBinding
import com.kineduchallenge.ui.events.ShowCharacter
import com.kineduchallenge.ui.events.ShowListComics
import com.kineduchallenge.ui.fragments.withArgs
import com.kineduchallenge.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var mViewBinding: FragmentCharacterBinding? = null
    private val mViewModel: CharacterViewModel by viewModels()

    private var mEpoxyController: ItemsEpoxyController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentCharacterBinding.inflate(inflater, container, false)
        return mViewBinding?.root
    }

    override fun onStart() {
        super.onStart()
        setupWidgets()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewBinding = null
        mEpoxyController = null
    }

    private fun setupWidgets() {
        mEpoxyController = ItemsEpoxyController()
        mViewBinding?.recyclerView?.adapter = mEpoxyController?.adapter
        mEpoxyController?.setListener(object : ItemsEpoxyController.Listener {
            override fun comicClicked(id: Int) {
                // Open the comic fragment
            }
        })

        mViewModel.mUIEventListener.observe(this) {
            it.getContentIfNotHandled()?.let { event ->
                var eventHandled = true
                when (event) {
                    is ShowCharacter -> showUserData(event.character)
                    is ShowListComics -> showComics(event.comics)
                    else -> eventHandled = false
                }
                if (eventHandled) it.setContentHandled()
            }
        }

        consultCharacter()
    }

    private fun consultCharacter() {
        arguments?.getInt(CHARACTER_ID)?.let { id ->
            mViewModel.consultCharacter(id)
        }
    }

    private fun showUserData(character: Character) {
        mViewBinding?.textName?.text = character.name
        mViewBinding?.textDescription?.text = character.description
        mViewBinding?.image?.load(character.thumbnail?.url)
    }

    private fun showComics(comics: List<Comic>) {
        mEpoxyController?.setData(comics)
    }

    companion object {
        const val TAG = "character_screen"
        private const val CHARACTER_ID = "character_id"

        fun newInstance(characterId: Int): CharacterFragment = CharacterFragment().withArgs {putInt(CHARACTER_ID, characterId)}
    }

}