package ru.kryu.camera.data.network.dto


import com.google.gson.annotations.SerializedName

data class ServerInfoDto(
    @SerializedName("Id")
    val id: String?,
//    @SerializedName("SenderId")
//    val senderId: String?,
//    @SerializedName("RevNum")
//    val revNum: Int?,
//    @SerializedName("Timestamp")
//    val timestamp: String?,
//    @SerializedName("XmlProtocolVersion")
//    val xmlProtocolVersion: Int?,
//    @SerializedName("ServerVersion")
//    val serverVersion: String?,
//    @SerializedName("ProductType")
//    val productType: String?,
//    @SerializedName("Servers")
//    val servers: List<Server?>?,
    @SerializedName("Channels")
    val channels: List<Channel?>?,
//    @SerializedName("RootSecObject")
//    val rootSecObject: RootSecObject?,
//    @SerializedName("UserGroup")
//    val userGroup: UserGroup?,
//    @SerializedName("MobileServerInfo")
//    val mobileServerInfo: MobileServerInfo?,
//    @SerializedName("RtspServerInfo")
//    val rtspServerInfo: RtspServerInfo?,
//    @SerializedName("MobileDevicesCapabilities")
//    val mobileDevicesCapabilities: MobileDevicesCapabilities?,
//    @SerializedName("GisConfig")
//    val gisConfig: Any?,
//    @SerializedName("WorldMapConfig")
//    val worldMapConfig: Any?,
//    @SerializedName("UseTimeZones")
//    val useTimeZones: Boolean?
) {
    data class Server(
        @SerializedName("Id")
        val id: String?,
        @SerializedName("Name")
        val name: String?,
        @SerializedName("Url")
        val url: String?,
        @SerializedName("PrimaryIp")
        val primaryIp: String?,
        @SerializedName("PrimaryPort")
        val primaryPort: String?,
        @SerializedName("PrimarySslPort")
        val primarySslPort: String?,
        @SerializedName("SecondaryIp")
        val secondaryIp: String?,
        @SerializedName("SecondaryPort")
        val secondaryPort: String?,
        @SerializedName("SecondarySslPort")
        val secondarySslPort: String?,
        @SerializedName("ConnectionUrl")
        val connectionUrl: String?
    )

    data class Channel(
        @SerializedName("Id")
        val id: String?,
        @SerializedName("Name")
        val name: String?,
        @SerializedName("Description")
        val description: String?,
        @SerializedName("DeviceInfo")
        val deviceInfo: String?,
        @SerializedName("AttachedToServer")
        val attachedToServer: String?,
        @SerializedName("IsDisabled")
        val isDisabled: Boolean?,
        @SerializedName("IsSoundOn")
        val isSoundOn: Boolean?,
        @SerializedName("IsArchivingEnabled")
        val isArchivingEnabled: Boolean?,
        @SerializedName("IsSoundArchivingEnabled")
        val isSoundArchivingEnabled: Boolean?,
        @SerializedName("AllowedRealtime")
        val allowedRealtime: Boolean?,
        @SerializedName("AllowedArchive")
        val allowedArchive: Boolean?,
        @SerializedName("IsPtzOn")
        val isPtzOn: Boolean?,
        @SerializedName("IsTransmitSoundOn")
        val isTransmitSoundOn: Boolean?,
        @SerializedName("ArchiveMode")
        val archiveMode: String?,
        @SerializedName("Streams")
        val streams: List<Stream?>?,
        @SerializedName("UserScenarios")
        val userScenarios: List<Any?>?,
        @SerializedName("ArchiveStreamType")
        val archiveStreamType: String?,
        @SerializedName("ArchiveVideoFormat")
        val archiveVideoFormat: String?,
        @SerializedName("ArchiveRotationMode")
        val archiveRotationMode: String?,
        @SerializedName("IsFaceRecOn")
        val isFaceRecOn: Boolean?,
        @SerializedName("GeoPosition")
        val geoPosition: Any?,
        @SerializedName("IsPeopleCountingOn")
        val isPeopleCountingOn: Boolean?,
        @SerializedName("IsObjectCountingOn")
        val isObjectCountingOn: Boolean?,
        @SerializedName("TimeZoneOffset")
        val timeZoneOffset: Double?
    ) {
        data class Stream(
            @SerializedName("StreamType")
            val streamType: String?,
            @SerializedName("StreamFormat")
            val streamFormat: String?,
            @SerializedName("RotationMode")
            val rotationMode: String?
        )
    }

    data class RootSecObject(
        @SerializedName("ChildSecObjects")
        val childSecObjects: List<ChildSecObject?>?,
        @SerializedName("ChildChannels")
        val childChannels: List<Any?>?,
        @SerializedName("Id")
        val id: String?,
        @SerializedName("Name")
        val name: String?
    ) {
        data class ChildSecObject(
            @SerializedName("ChildSecObjects")
            val childSecObjects: List<ChildSecObject?>?,
            @SerializedName("ChildChannels")
            val childChannels: List<String?>?,
            @SerializedName("Id")
            val id: String?,
            @SerializedName("Name")
            val name: String?
        )
    }

    data class UserGroup(
        @SerializedName("GridTypesAllowed")
        val gridTypesAllowed: List<String?>?,
        @SerializedName("Id")
        val id: String?,
        @SerializedName("Comment")
        val comment: String?,
        @SerializedName("Name")
        val name: String?,
        @SerializedName("CanConfigure")
        val canConfigure: Boolean?,
        @SerializedName("CanConfigureWorkplace")
        val canConfigureWorkplace: Boolean?,
        @SerializedName("CanShutdown")
        val canShutdown: Boolean?,
        @SerializedName("CanChangeChannelMode")
        val canChangeChannelMode: Boolean?,
        @SerializedName("CanManageRec")
        val canManageRec: Boolean?,
        @SerializedName("CanAccessExpertMode")
        val canAccessExpertMode: Boolean?,
        @SerializedName("CanPTZ")
        val canPTZ: Boolean?,
        @SerializedName("PtzPriority")
        val ptzPriority: String?,
        @SerializedName("CanReceiveSound")
        val canReceiveSound: Boolean?,
        @SerializedName("CanTransmitSound")
        val canTransmitSound: Boolean?,
        @SerializedName("CanAccessNewCamera")
        val canAccessNewCamera: Boolean?,
        @SerializedName("CanAccessReports")
        val canAccessReports: Boolean?,
        @SerializedName("CanGetTranscodedVideoFromMobileServer")
        val canGetTranscodedVideoFromMobileServer: Boolean?,
        @SerializedName("CanAccessEditingAnalystPluginsInClient")
        val canAccessEditingAnalystPluginsInClient: Boolean?,
        @SerializedName("CanAccessVideoViaWeb")
        val canAccessVideoViaWeb: Boolean?,
        @SerializedName("CanAccessVideoViaSmartTV")
        val canAccessVideoViaSmartTV: Boolean?,
        @SerializedName("CanExportVideoToAvi")
        val canExportVideoToAvi: Boolean?,
        @SerializedName("CanUseArchiveExport")
        val canUseArchiveExport: Boolean?,
        @SerializedName("CanReceiveMainStream")
        val canReceiveMainStream: Boolean?,
        @SerializedName("IsAllForbidden")
        val isAllForbidden: Boolean?,
        @SerializedName("CanAccessUnifiedLog")
        val canAccessUnifiedLog: Boolean?,
        @SerializedName("CanAccessArchiveMarks")
        val canAccessArchiveMarks: Boolean?,
        @SerializedName("CanAccessSearch")
        val canAccessSearch: Boolean?,
        @SerializedName("CanAccessToAllUsersInUnifiedLog")
        val canAccessToAllUsersInUnifiedLog: Boolean?,
        @SerializedName("CanReceiveMobilePush")
        val canReceiveMobilePush: Boolean?,
        @SerializedName("MessengerCanSendMessages")
        val messengerCanSendMessages: Boolean?,
        @SerializedName("MessengerCanReceiveMessages")
        val messengerCanReceiveMessages: Boolean?,
        @SerializedName("CanConfigureVideowall")
        val canConfigureVideowall: Boolean?,
        @SerializedName("CanBrowsingVideowall")
        val canBrowsingVideowall: Boolean?,
        @SerializedName("CanAccessPlans")
        val canAccessPlans: Boolean?,
        @SerializedName("CanChangePassword")
        val canChangePassword: Boolean?,
        @SerializedName("CanRunUserScenarios")
        val canRunUserScenarios: Boolean?,
        @SerializedName("CanAccessGis")
        val canAccessGis: Boolean?,
        @SerializedName("WatermarkSettings")
        val watermarkSettings: WatermarkSettings?
    ) {
        data class WatermarkSettings(
            @SerializedName("IsEnabled")
            val isEnabled: Boolean?,
            @SerializedName("DisplayMode")
            val displayMode: String?
        )
    }

    data class MobileServerInfo(
        @SerializedName("IsEnabled")
        val isEnabled: Boolean?,
        @SerializedName("IsProxyEnabled")
        val isProxyEnabled: Boolean?,
        @SerializedName("IsMobilePushEnabled")
        val isMobilePushEnabled: Boolean?,
        @SerializedName("Port")
        val port: Int?,
        @SerializedName("UsePFrames")
        val usePFrames: Boolean?,
        @SerializedName("FpsLimit")
        val fpsLimit: Int?,
        @SerializedName("LowResolution")
        val lowResolution: String?,
        @SerializedName("MiddleResolution")
        val middleResolution: String?,
        @SerializedName("HighResolution")
        val highResolution: String?,
        @SerializedName("Resolutions")
        val resolutions: List<Resolution?>?
    ) {
        data class Resolution(
            @SerializedName("Width")
            val width: Int?,
            @SerializedName("Height")
            val height: Int?,
            @SerializedName("IsEnabled")
            val isEnabled: Boolean?,
            @SerializedName("FpsLimit")
            val fpsLimit: Int?,
            @SerializedName("UsePFrames")
            val usePFrames: Boolean?,
            @SerializedName("Type")
            val type: String?
        )
    }

    data class RtspServerInfo(
        @SerializedName("IsEnabled")
        val isEnabled: Boolean?,
        @SerializedName("TcpPort")
        val tcpPort: Int?,
        @SerializedName("IsMjpegEnabled")
        val isMjpegEnabled: Boolean?
    )

    data class MobileDevicesCapabilities(
        @SerializedName("Archive")
        val archive: Boolean?,
        @SerializedName("Ptz")
        val ptz: Boolean?,
        @SerializedName("Hls")
        val hls: Boolean?,
        @SerializedName("AppleMobilePush")
        val appleMobilePush: Boolean?,
        @SerializedName("AndroidMobilePush")
        val androidMobilePush: Boolean?,
        @SerializedName("Profiles")
        val profiles: Boolean?,
        @SerializedName("UserScenarios")
        val userScenarios: Boolean?,
        @SerializedName("SmartAssistant")
        val smartAssistant: Boolean?,
        @SerializedName("Gis")
        val gis: Boolean?
    )
}