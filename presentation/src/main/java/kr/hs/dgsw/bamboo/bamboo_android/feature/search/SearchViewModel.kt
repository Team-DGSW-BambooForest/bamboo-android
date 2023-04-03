package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.HomeState
import kr.hs.dgsw.bamboo.domain.usecase.SearchPostUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchPostUseCase: SearchPostUseCase
) : ContainerHost<SearchState, Unit>, ViewModel() {

    override val container = container<SearchState, Unit>(SearchState())

    fun searchPost(word: String) = intent {
        searchPostUseCase(word)
            .onSuccess {
                reduce {
                    state.copy(postList = it)
                }
            }
            .onFailure {
                reduce {
                    state.copy(exception = it)
                }
            }
    }
}