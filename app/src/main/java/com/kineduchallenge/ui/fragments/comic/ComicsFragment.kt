package com.kineduchallenge.ui.fragments.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kineduchallenge.core.database.schema.Character
import com.kineduchallenge.databinding.FragmentComicsBinding
import com.kineduchallenge.ui.events.ShowListCharacters
import com.kineduchallenge.viewmodel.CharactersViewModel
import com.kineduchallenge.viewmodel.MainViewModel

class ComicsFragment : Fragment() {

    private var mViewBinding: FragmentComicsBinding? = null
    private val mViewModel: CharactersViewModel by viewModels()
    private val mMainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentComicsBinding.inflate(inflater, container, false)
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
            }
        }
    }

    companion object {
        const val TAG = "comics_screen"

        fun newInstance() = ComicsFragment()
    }

}