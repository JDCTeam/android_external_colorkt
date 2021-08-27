package dev.kdrag0n.colorkt.tests

import dev.kdrag0n.colorkt.Color.Companion.convert
import dev.kdrag0n.colorkt.rgb.Srgb
import dev.kdrag0n.colorkt.ucs.lab.Oklab
import dev.kdrag0n.colorkt.ucs.lab.Oklab.Companion.toOklab
import dev.kdrag0n.colorkt.ucs.lch.CieLch
import dev.kdrag0n.colorkt.ucs.lch.Oklch
import dev.kdrag0n.colorkt.ucs.lch.Oklch.Companion.toOklch
import kotlin.test.Test
import kotlin.test.assertEquals

class Conversion {
    @Test
    fun testLongConversion() {
        val jzczhz = CieLch(50.0, 20.0, 1.0)
        val autoOklch = jzczhz.convert<Oklch>()
        val manualOklch = jzczhz.toCieLab().toXyz().toLinearSrgb().toOklab().toOklch()
        assertEquals(autoOklch, manualOklch)
    }

    @Test
    fun testNopConversion() {
        val color = Oklab(0.5, 0.3, 0.5)
        assertEquals(color, color.convert())
    }

    @Test
    fun testSrgbHex() {
        listOf("#ff0000", "#00ff00", "#0000ff").forEach { sample ->
            val parsed = Srgb(sample)
            val encoded = parsed.toHex()
            assertEquals(sample, encoded)
        }
    }
}
