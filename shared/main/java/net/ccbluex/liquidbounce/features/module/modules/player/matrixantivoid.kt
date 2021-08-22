/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.player

import net.ccbluex.liquidbounce.api.minecraft.client.settings.IKeyBinding
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.utils.misc.RandomUtils
import net.ccbluex.liquidbounce.utils.timer.MSTimer
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.FloatValue
import net.ccbluex.liquidbounce.value.IntegerValue
import net.ccbluex.liquidbounce.value.ListValue

@ModuleInfo(name = "MatrixAntiVoid", description = "Prevents you from getting kicked for being AFK.", category = ModuleCategory.PLAYER)
class matrixantivoid : Module() {
    private var OPTPMODE = false

    @EventTarget
    fun onUpdate(event: UpdateEvent) {
        val thePlayer = mc.thePlayer ?: return
        if (mc.thePlayer!!.fallDistance > 10f) {
            OPTPMODE = true
            mc.thePlayer!!.onGround = true
            mc.thePlayer!!.sendQueue.addToSendQueue(classProvider.createCPacketPlayer(true))
        }
        if (OPTPMODE == true) {
            mc.thePlayer!!.setPosition(mc.thePlayer!!.posX, mc.thePlayer!!.posY + 110, mc.thePlayer!!.posZ)
            mc.thePlayer!!.setPosition(mc.thePlayer!!.posX, mc.thePlayer!!.posY, mc.thePlayer!!.posZ)
            mc.thePlayer!!.fallDistance = 0f
            OPTPMODE = false
        }
    }



    override fun onDisable() {OPTPMODE = false}}