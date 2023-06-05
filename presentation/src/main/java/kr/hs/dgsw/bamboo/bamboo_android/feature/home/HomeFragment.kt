package kr.hs.dgsw.bamboo.bamboo_android.feature.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.base.BaseFragment
import kr.hs.dgsw.bamboo.bamboo_android.databinding.FragmentHomeBinding
import kr.hs.dgsw.bamboo.bamboo_android.feature.home.adapter.PostAdapter
import kr.hs.dgsw.bamboo.domain.entity.post.Post

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun start() {
        setPostAdapter()
        collectState()
        collectError()
    }

    private fun collectState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                postAdapter.submitList(state.postList?.list)
            }
        }
    }

    private fun collectError() {
        lifecycleScope.launchWhenStarted {
            viewModel.error.collect { message ->
                if (message.isNotBlank())
                    showToast(message)
            }
        }
    }

    private fun setPostAdapter(/*imageUrl: String?*/) {
        postAdapter = PostAdapter(/*imageUrl*/) {

        }
        binding.rvPost.adapter = postAdapter
    }
}
