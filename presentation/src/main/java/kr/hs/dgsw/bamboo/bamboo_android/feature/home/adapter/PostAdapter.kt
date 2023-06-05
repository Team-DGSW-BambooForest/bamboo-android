package kr.hs.dgsw.bamboo.bamboo_android.feature.home.adapter

import android.opengl.Visibility
import android.view.View
import com.bumptech.glide.Glide
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.base.BaseListAdapter
import kr.hs.dgsw.bamboo.bamboo_android.databinding.ItemPostBinding
import kr.hs.dgsw.bamboo.domain.entity.post.Post

class PostAdapter(
//    private val imageUrl: String?,
    private val onClick: (post: Post) -> Unit
) : BaseListAdapter<Post, ItemPostBinding>(R.layout.item_post, PostDiffUtilCallback) {

    override fun action(item: Post, binding: ItemPostBinding) {
        binding.apply {
            tvName.text = item.author
            tvDate.text = item.createTime
            tvContent.text = item.content

//            if (imageUrl.isNullOrBlank())
//                ivImage.visibility = View.INVISIBLE
//            else {
//                ivImage.visibility = View.VISIBLE
//
//                Glide.with(root)
//                    .load(imageUrl)
//                    .into(ivImage)
//            }

            Glide.with(root)
                .load(item.profileImage)
                .into(ivProfile)

            root.setOnClickListener {
                onClick(item)
            }
        }
    }
}