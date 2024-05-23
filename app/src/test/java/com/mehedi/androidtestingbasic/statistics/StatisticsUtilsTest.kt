package com.mehedi.androidtestingbasic.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {
    
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        
        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)
        
        // Check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }
    
    @Test
    fun getActiveAndCompletedStats_both_returns_forty_sixty() {
        
        // Create 5  tasks , 2 is completed , 3 is active
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)
        
        // Check the result
        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }
    
}

