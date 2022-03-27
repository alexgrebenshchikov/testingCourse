package com.example.camera_app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.example.camera_app.activity.CalibrateSensorsActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
@LargeTest
class CalibrateSensorsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(CalibrateSensorsActivity::class.java)


    // 1. проверяем, что текст на TextView, отображающих показания акселерометра был обновлён
    @Test
    fun checkAccelerometerValues() {
        sleep(1000)
        onView(withId(R.id.accelerometerX)).check(matches(not(withText(R.string.acc_x_label))))
        onView(withId(R.id.accelerometerY)).check(matches(not(withText(R.string.acc_y_label))))
        onView(withId(R.id.accelerometerZ)).check(matches(not(withText(R.string.acc_z_label))))
    }
    // 2.
    @Test
    fun checkGyroscopeValues() {
        sleep(1000)
        onView(withId(R.id.gyroscopeX)).check(matches(not(withText(R.string.acc_x_label))))
        onView(withId(R.id.gyroscopeY)).check(matches(not(withText(R.string.acc_y_label))))
        onView(withId(R.id.gyroscopeZ)).check(matches(not(withText(R.string.acc_z_label))))
    }

    // 3.
    @Test
    fun checkAccelerometerDialog() {
        onView(withId(R.id.acceleratorCalibrationStartButton)).perform(click())
        onView(withText(R.string.calibrate_accelerometer_dialog)).check(matches(isDisplayed()))
    }

    // 3.1
    @Test
    fun checkAccelerometerDialogCancel() {
        onView(withId(R.id.acceleratorCalibrationStartButton)).perform(click())
        onView(withText(R.string.cancel)).perform(click())
        onView(withText(R.string.calibrate_accelerometer_dialog)).check(doesNotExist())
    }

    // 3.2
    @Test
    fun checkAccelerometerDialogOk() {
        onView(withId(R.id.acceleratorCalibrationStartButton)).perform(click())
        onView(withText(R.string.ok)).perform(click())
        onView(withId(R.id.acceleratorCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.gyroscopeCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withText(R.string.calibrate_accelerometer_dialog)).check(doesNotExist())
    }

    // 4.
    @Test
    fun checkGyroscopeDialog() {
        onView(withId(R.id.gyroscopeCalibrationStartButton)).perform(click())
        onView(withText(R.string.calibrate_gyroscope_dialog)).check(matches(isDisplayed()))
    }

    // 4.1
    @Test
    fun checkGyroscopeDialogCancel() {
        onView(withId(R.id.gyroscopeCalibrationStartButton)).perform(click())
        onView(withText(R.string.cancel)).perform(click())
        onView(withText(R.string.calibrate_gyroscope_dialog)).check(doesNotExist())
    }

    // 4.2
    @Test
    fun checkGyroscopeDialogOk() {
        onView(withId(R.id.gyroscopeCalibrationStartButton)).perform(click())
        onView(withText(R.string.ok)).perform(click())
        onView(withId(R.id.acceleratorCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.gyroscopeCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withText(R.string.calibrate_gyroscope_dialog)).check(doesNotExist())
    }

    // 5.
    @Test
    fun checkButtonsStatePersistsAcrossRotation() {
        val device = UiDevice.getInstance(getInstrumentation())
        onView(withId(R.id.acceleratorCalibrationStartButton)).perform(click())
        onView(withText(R.string.ok)).perform(click())
        onView(withId(R.id.acceleratorCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.gyroscopeCalibrationStartButton)).check(matches(not(isEnabled())))
        device.setOrientationLeft()
        onView(withId(R.id.acceleratorCalibrationStartButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.gyroscopeCalibrationStartButton)).check(matches(not(isEnabled())))
    }


    // 6.
    @Test
    fun checkAccDialogStatePersistsAcrossRotation() {
        val device = UiDevice.getInstance(getInstrumentation())
        onView(withId(R.id.acceleratorCalibrationStartButton)).perform(click())
        onView(withText(R.string.calibrate_accelerometer_dialog)).check(matches(isDisplayed()))
        device.setOrientationLeft()
        onView(withText(R.string.calibrate_accelerometer_dialog)).check(matches(isDisplayed()))
    }

    @Test
    fun checkGyrDialogStatePersistsAcrossRotation() {
        val device = UiDevice.getInstance(getInstrumentation())
        onView(withId(R.id.gyroscopeCalibrationStartButton)).perform(click())
        onView(withText(R.string.calibrate_gyroscope_dialog)).check(matches(isDisplayed()))
        device.setOrientationLeft()
        onView(withText(R.string.calibrate_gyroscope_dialog)).check(matches(isDisplayed()))
    }


}
