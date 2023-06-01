package kr.hs.dgsw.bamboo.bamboo_android.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.hs.dgsw.bamboo.bamboo_android.BR


abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {
    protected lateinit var binding: B
    protected lateinit var mViewModel: VM

    protected abstract val viewModel: VM

    protected abstract fun start()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
        start()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        binding.setVariable(BR._all, mViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::binding.isInitialized) binding.unbind()
    }
}
