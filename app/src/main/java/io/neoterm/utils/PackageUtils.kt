package io.neoterm.utils

import io.neoterm.R
import io.neoterm.preference.NeoPreference
import io.neoterm.preference.NeoTermPath
import java.io.File

/**
 * @author kiva
 */
object PackageUtils {
    fun syncSource() {
        val source = NeoPreference.loadString(R.string.key_package_source, NeoTermPath.DEFAULT_SOURCE)
        val sourceFile = File(NeoTermPath.SOURCE_FILE)
        FileUtils.writeFile(sourceFile, generateSourceFile(source).toByteArray())
    }

    private fun generateSourceFile(source: String): String {
        return StringBuilder().append("# Generated by NeoTerm-Preference\n")
                .append("deb ")
                .append(source)
                .append(" stable main")
                .append("\n")
                .toString()
    }
}