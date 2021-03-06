package org.pacien.tincapp.commands

import org.pacien.tincapp.context.AppPaths

/**
 * @author pacien
 */
object Tincd {

    fun start(netName: String, fd: Int) {
        Executor.forkExec(Command(AppPaths.tincd().absolutePath)
                .withOption("no-detach")
                .withOption("config", AppPaths.confDir(netName).absolutePath)
                .withOption("pidfile", AppPaths.pidFile(netName).absolutePath)
                .withOption("logfile", AppPaths.logFile(netName).absolutePath)
                .withOption("option", "DeviceType=fd")
                .withOption("option", "Device=" + fd))
    }

}
