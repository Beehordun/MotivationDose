package com.biodun.mindvalley.features.channel.domain

import com.biodun.mindvalley.features.channel.testFakeFactory.CategoryTestFactory
import com.biodun.mindvalley.features.channel.domain.repositories.CategoryRepository
import com.biodun.mindvalley.features.channel.domain.usecases.GetCategoryUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetCategoryUseCaseTest {

    private lateinit var categoryUseCase: GetCategoryUseCase
    private val categoryRepository: CategoryRepository = mock()
    private val categoryData = CategoryTestFactory.getCategoryData()

    @Before
    fun setUp() {
        categoryUseCase = GetCategoryUseCase(categoryRepository)
    }

    @Test
    fun getCategoryData_returnsCategoryData() {
        whenever(categoryRepository.getCategory())
            .thenReturn(Single.just(categoryData))

        val test = categoryUseCase.getCategoryData().test()

        verify(categoryRepository).getCategory()

        test.run {
            assertNoErrors()
            assertComplete()
            assertValueCount(1)
            val response = test.values()[0]
            Assert.assertNotNull(response)
            Assert.assertEquals(response, categoryData)
            dispose()
        }
    }
}
