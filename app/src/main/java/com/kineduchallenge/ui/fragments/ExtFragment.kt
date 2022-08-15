package com.kineduchallenge.ui.fragments

import android.annotation.TargetApi
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun Fragment.addChildFragment(fragment: Fragment, @IdRes frameId: Int, tag: String? = null) {
    childFragmentManager.transact {
        replace(frameId, fragment, tag)
    }
}

fun Fragment.getSafeString(@StringRes stringResource: Int, defaultString: String = ""): String =
    context?.resources?.getString(stringResource) ?: defaultString

fun Fragment.getColorResource(@ColorRes colorResource: Int): Int {
    context ?: return Color.WHITE
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context!!.resources.getColor(colorResource, context!!.theme)
    } else {
        context!!.resources.getColor(colorResource)
    }
}

fun Fragment.getDrawableResource(@DrawableRes drawableResource: Int): Drawable? =
    context?.resources?.getDrawable(drawableResource, context?.theme)

inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().also { it.action() }.commit()
}

@Suppress("UnnecessaryApply")
inline fun <T : Fragment> T.withArgs(argsBuilder: Bundle.() -> Unit): T =
    this.apply { arguments = Bundle().apply(argsBuilder) }

@Suppress("UnnecessaryApply")
inline fun <T : BottomSheetDialogFragment> T.withArgs(argsBuilder: Bundle.() -> Unit): T =
    this.apply { arguments = Bundle().apply(argsBuilder) }

@TargetApi(Build.VERSION_CODES.M)
fun Fragment.requestPermissionsSafely(permissions: Array<String?>, requestCode: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(permissions, requestCode)
    }
}
