package com.example.camera_app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.Matchers.not

object CalibrateSensorsPage {
    private val accelerometerLabelX = withId(R.id.accelerometerX)
    private val accelerometerLabelY = withId(R.id.accelerometerY)
    private val accelerometerLabelZ = withId(R.id.accelerometerZ)

    private val gyroscopeLabelX = withId(R.id.gyroscopeX)
    private val gyroscopeLabelY = withId(R.id.gyroscopeY)
    private val gyroscopeLabelZ = withId(R.id.gyroscopeZ)

    private val accStartButton = withId(R.id.acceleratorCalibrationStartButton)
    private val gyrStartButton = withId(R.id.gyroscopeCalibrationStartButton)

    private val accDialog = withText(R.string.calibrate_accelerometer_dialog)
    private val gyrDialog = withText(R.string.calibrate_gyroscope_dialog)
    private val okDialogButton = withText(R.string.ok)
    private val cancelDialogButton = withText(R.string.cancel)

    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun checkAccLabelsIsChanged() {
        Thread.sleep(1000)
        onView(accelerometerLabelX)
            .check(matches(not(withText(R.string.acc_x_label))))
        onView(accelerometerLabelY)
            .check(matches(not(withText(R.string.acc_y_label))))
        onView(accelerometerLabelZ)
            .check(matches(not(withText(R.string.acc_z_label))))
    }

    fun checkGyrLabelsIsChanged() {
        Thread.sleep(1000)
        onView(gyroscopeLabelX)
            .check(matches(not(withText(R.string.acc_x_label))))
        onView(gyroscopeLabelY)
            .check(matches(not(withText(R.string.acc_y_label))))
        onView(gyroscopeLabelZ)
            .check(matches(not(withText(R.string.acc_z_label))))
    }

    fun clickAccCalibrationStartButton() {
        onView(accStartButton).perform(click())
    }

    fun checkAccDialogIsDisplayed() {
        onView(accDialog).check(matches(isDisplayed()))
    }

    fun checkAccDialogDoesNotExists() {
        onView(accDialog).check(doesNotExist())
    }

    fun clickDialogCancelButton() {
        onView(cancelDialogButton).perform(click())
    }

    fun clickDialogOkButton() {
        onView(okDialogButton).perform(click())
    }

    fun checkAccCalibrationStartButtonIsNotEnabled() {
        onView(accStartButton).check(matches(not(isEnabled())))
    }

    fun checkGyrCalibrationStartButtonIsNotEnabled() {
        onView(gyrStartButton).check(matches(not(isEnabled())))
    }

    fun clickGyrCalibrationStartButton() {
        onView(gyrStartButton).perform(click())
    }

    fun checkGyrDialogIsDisplayed() {
        onView(gyrDialog).check(matches(isDisplayed()))
    }

    fun checkGyrDialogDoesNotExists() {
        onView(gyrDialog).check(doesNotExist())
    }

    fun changeOrientation() {
        device.setOrientationLeft()
    }
}
