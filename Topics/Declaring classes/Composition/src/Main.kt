data class OperatingSystem(
    var name: String = "Windows"
)

data class DualBoot(
    var primaryOs: OperatingSystem = OperatingSystem(),
    var secondaryOs: OperatingSystem = OperatingSystem()
)