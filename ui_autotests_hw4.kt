package com.example.camera_app

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.camera_app.activity.CalibrateSensorsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class CalibrateSensorsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(CalibrateSensorsActivity::class.java)


    // 1. проверяем, что текст на TextView, отображающих показания акселерометра был обновлён
    @Test
    fun checkAccelerometerValues() {
        CalibrateSensorsPage.checkAccLabelsIsChanged()
    }
    // 2.
    @Test
    fun checkGyroscopeValues() {
        CalibrateSensorsPage.checkGyrLabelsIsChanged()
    }

    // 3.
    @Test
    fun checkAccelerometerDialog() {
        CalibrateSensorsPage.clickAccCalibrationStartButton()
        CalibrateSensorsPage.checkAccDialogIsDisplayed()
    }

    // 3.1
    @Test
    fun checkAccelerometerDialogCancel() {
        CalibrateSensorsPage.clickAccCalibrationStartButton()
        CalibrateSensorsPage.clickDialogCancelButton()
        CalibrateSensorsPage.checkAccDialogDoesNotExists()
    }

    // 3.2
    @Test
    fun checkAccelerometerDialogOk() {
        CalibrateSensorsPage.clickAccCalibrationStartButton()
        CalibrateSensorsPage.clickDialogOkButton()
        CalibrateSensorsPage.checkAccCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkGyrCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkAccDialogDoesNotExists()
    }

    // 4.
    @Test
    fun checkGyroscopeDialog() {
        CalibrateSensorsPage.clickGyrCalibrationStartButton()
        CalibrateSensorsPage.checkGyrDialogIsDisplayed()
    }

    // 4.1
    @Test
    fun checkGyroscopeDialogCancel() {
        CalibrateSensorsPage.clickGyrCalibrationStartButton()
        CalibrateSensorsPage.clickDialogCancelButton()
        CalibrateSensorsPage.checkGyrDialogDoesNotExists()
    }

    // 4.2
    @Test
    fun checkGyroscopeDialogOk() {
        CalibrateSensorsPage.clickGyrCalibrationStartButton()
        CalibrateSensorsPage.clickDialogOkButton()
        CalibrateSensorsPage.checkAccCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkGyrCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkGyrDialogDoesNotExists()
    }

    // 5.
    @Test
    fun checkButtonsStatePersistsAcrossRotation() {
        CalibrateSensorsPage.clickAccCalibrationStartButton()
        CalibrateSensorsPage.clickDialogOkButton()
        CalibrateSensorsPage.checkAccCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkGyrCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.changeOrientation()
        CalibrateSensorsPage.checkAccCalibrationStartButtonIsNotEnabled()
        CalibrateSensorsPage.checkGyrCalibrationStartButtonIsNotEnabled()
    }


    // 6.
    @Test
    fun checkAccDialogStatePersistsAcrossRotation() {
        CalibrateSensorsPage.clickAccCalibrationStartButton()
        CalibrateSensorsPage.checkAccDialogIsDisplayed()
        CalibrateSensorsPage.changeOrientation()
        CalibrateSensorsPage.checkAccDialogIsDisplayed()
    }

    @Test
    fun checkGyrDialogStatePersistsAcrossRotation() {
        CalibrateSensorsPage.clickGyrCalibrationStartButton()
        CalibrateSensorsPage.checkGyrDialogIsDisplayed()
        CalibrateSensorsPage.changeOrientation()
        CalibrateSensorsPage.checkGyrDialogIsDisplayed()
    }

}
