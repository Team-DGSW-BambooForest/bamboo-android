package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.HomeState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
) : ContainerHost<SearchState, Unit>, ViewModel() {

    override val container = container<SearchState, Unit>(SearchState())

}