/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.utils

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
private var abc = false
object MovementUtils : MinecraftInstance() {

    val speed: Float
        get() = sqrt(mc.thePlayer!!.motionX * mc.thePlayer!!.motionX + mc.thePlayer!!.motionZ * mc.thePlayer!!.motionZ).toFloat()

    @JvmStatic
    val isMoving: Boolean
        get() = mc.thePlayer != null && (mc.thePlayer!!.movementInput.moveForward != 0f || mc.thePlayer!!.movementInput.moveStrafe != 0f)

    fun hasMotion(): Boolean {
        return mc.thePlayer!!.motionX != 0.0 && mc.thePlayer!!.motionZ != 0.0 && mc.thePlayer!!.motionY != 0.0
    }

    @JvmStatic
    @JvmOverloads
    fun strafe(speed: Float = this.speed) {
        if (!isMoving) return
        val yaw = direction
        val thePlayer = mc.thePlayer!!
        thePlayer.motionX = -sin(yaw) * speed
        thePlayer.motionZ = cos(yaw) * speed
    }

    @JvmStatic
    fun IsDiagonal(): Boolean {
        val thePlayer = mc.thePlayer!!
        if (thePlayer.motionX > 0.1 && thePlayer.motionZ > 0.1) {
            abc = true
        }
        if (thePlayer.motionX < -0.1 && thePlayer.motionZ < -0.1) {
            abc = true
        }
        return abc
    }
    @JvmStatic
    fun HClip(length: Double) {
        val thePlayer = mc.thePlayer!!
        val yaw = Math.toRadians(thePlayer.rotationYaw.toDouble())
        val x = -sin(yaw) * length
        val z = cos(yaw) * length
        thePlayer.setPosition(thePlayer.posX + x, thePlayer.posY, thePlayer.posZ + z)
    }
    @JvmStatic
    fun VClip(length: Double) {
        val thePlayer = mc.thePlayer!!
        thePlayer.setPosition(thePlayer.posX, thePlayer.posY + length, thePlayer.posZ)
    }
    @JvmStatic
    fun Clip(length: Double, length2: Double) {
        val thePlayer = mc.thePlayer!!
        val yaw = Math.toRadians(thePlayer.rotationYaw.toDouble())
        val x = -sin(yaw) * length
        val z = cos(yaw) * length
        thePlayer.setPosition(thePlayer.posX + x, thePlayer.posY + length2, thePlayer.posZ + z)
    }
    @JvmStatic
    fun forward(length: Double) {
        val thePlayer = mc.thePlayer!!
        val yaw = Math.toRadians(thePlayer.rotationYaw.toDouble())
        thePlayer.setPosition(thePlayer.posX + -sin(yaw) * length, thePlayer.posY, thePlayer.posZ + cos(yaw) * length)
    }

    @JvmStatic
    val direction: Double
        get() {
            val thePlayer = mc.thePlayer!!
            var rotationYaw = thePlayer.rotationYaw
            if (thePlayer.moveForward < 0f) rotationYaw += 180f
            var forward = 1f
            if (thePlayer.moveForward < 0f) forward = -0.5f else if (thePlayer.moveForward > 0f) forward = 0.5f
            if (thePlayer.moveStrafing > 0f) rotationYaw -= 90f * forward
            if (thePlayer.moveStrafing < 0f) rotationYaw += 90f * forward
            return Math.toRadians(rotationYaw.toDouble())
        }
}