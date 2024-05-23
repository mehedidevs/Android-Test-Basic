package com.mehedi.androidtestingbasic.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {
    // if there is only task in the list with 0 completed & 100 active
    // then return the 40, 60
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }
    
    // if there are 5 task in the list with 2 completed & 3 active
    // then return the 40, 60
    @Test
    fun getActiveAndCompletedStats_both_returns_forty_sixty() {
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
        )
        val result = getActiveAndCompletedStats(tasks)
        
        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }
    
    // if there is no task list is empty
    // then return the 0, 0
    @Test
    fun getActiveAndCompletedStats_tasks_empty_returns_zero_zero() {
        val tasks = emptyList<Task>()
        
        val result = getActiveAndCompletedStats(tasks)
        
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
    
    
    // if there is no task list is null
    // then return the 0, 0
    @Test
    fun getActiveAndCompletedStats_tasks_null_returns_zero_zero() {
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)
        
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }
    
}

