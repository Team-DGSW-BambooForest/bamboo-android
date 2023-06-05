package kr.hs.dgsw.bamboo.bamboo_android.feature.home.adapter

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.bamboo.domain.entity.post.Post

object PostDiffUtilCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.postId == newItem.postId
    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem.content == newItem.content
}
