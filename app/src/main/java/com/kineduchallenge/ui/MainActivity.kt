package com.kineduchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.kineduchallenge.R
import com.kineduchallenge.databinding.ActivityMainBinding
import com.kineduchallenge.ui.events.OpenCharacterScreen
import com.kineduchallenge.ui.fragments.character.CharacterFragment
import com.kineduchallenge.ui.fragments.character.CharactersFragment
import com.kineduchallenge.ui.fragments.comic.ComicsFragment
import com.kineduchallenge.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private var mViewBinding: ActivityMainBinding? = null
    val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setupWidgets()
    }

    private fun setupWidgets() {
        showFragment(CharactersFragment(), CharactersFragment.TAG)
        mViewBinding?.navigation?.bringToFront()
        mViewBinding?.navigation?.setOnItemSelectedListener(this)

        mViewModel?.mNavigationEventListener?.observe(this) {
            it.getContentIfNotHandled()?.let { event ->
                var eventHandled = true
                when (event) {
                    is OpenCharacterScreen -> {
                        val fragment = CharacterFragment.newInstance(event.idCharacter)
                        showFragment(fragment, CharacterFragment.TAG, false)
                    }
                    else -> eventHandled = false
                }
                if (eventHandled) it.setContentHandled()
            }
        }
    }

    private fun showFragment(fragment: Fragment, tag: String, replace: Boolean = true) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (replace) {
            fragmentTransaction.replace(R.id.frame_layout, fragment, tag)
        } else {
            fragmentTransaction.add(R.id.frame_layout, fragment, tag)
        }
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.characters -> {
                showFragment(CharactersFragment(), CharactersFragment.TAG)
                true
            }
            R.id.comics -> {
                showFragment(ComicsFragment(), ComicsFragment.TAG)
                true
            }
            R.id.series -> true
            R.id.stories -> true
            R.id.events -> true
            else -> false
        }
    }

}