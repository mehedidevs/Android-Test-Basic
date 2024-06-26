package com.mehedi.androidtestingbasic.tasks


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mehedi.androidtestingbasic.getOrAwaitValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    
    // Subject under test
    private lateinit var tasksViewModel: TasksViewModel
    
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    
    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }
    
    @Test
    fun addNewTask_setsNewTaskEvent() {
        
        // When adding a new task
        tasksViewModel.addNewTask()
        
        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(
            value.getContentIfNotHandled(), (not(nullValue()))
        )
        
    }
    
    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {
        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
        
        // Then the "Add task" action is visible
        val value = tasksViewModel.tasksAddViewVisible.getOrAwaitValue()
        assertThat(value, `is`(true))
    }
    
}