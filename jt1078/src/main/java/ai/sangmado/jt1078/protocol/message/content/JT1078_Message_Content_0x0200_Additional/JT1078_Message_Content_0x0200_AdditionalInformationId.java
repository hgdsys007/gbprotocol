package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import lombok.Getter;
import lombok.Setter;

import static ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion.V2016;

/**
 * JT/T 1078 位置附加信息ID
 */
@Getter
@Setter
public class JT1078_Message_Content_0x0200_AdditionalInformationId extends JT808_Message_Content_0x0200_AdditionalInformationId {
    public static final JT1078_Message_Content_0x0200_AdditionalInformationId JT1078_0x0200_0x14 = new JT1078_Message_Content_0x0200_AdditionalInformationId("JT1078_0x200_0x14", 0x14, V2016, "视频相关报警标志位");
    public static final JT1078_Message_Content_0x0200_AdditionalInformationId JT1078_0x0200_0x15 = new JT1078_Message_Content_0x0200_AdditionalInformationId("JT1078_0x200_0x15", 0x15, V2016, "视频信号丢失报警状态");
    public static final JT1078_Message_Content_0x0200_AdditionalInformationId JT1078_0x0200_0x16 = new JT1078_Message_Content_0x0200_AdditionalInformationId("JT1078_0x200_0x16", 0x16, V2016, "视频信号遮挡报警状态");
    public static final JT1078_Message_Content_0x0200_AdditionalInformationId JT1078_0x0200_0x17 = new JT1078_Message_Content_0x0200_AdditionalInformationId("JT1078_0x200_0x17", 0x17, V2016, "存储器故障报警状态");
    public static final JT1078_Message_Content_0x0200_AdditionalInformationId JT1078_0x0200_0x18 = new JT1078_Message_Content_0x0200_AdditionalInformationId("JT1078_0x200_0x18", 0x18, V2016, "异常驾驶行为报警详细描述");

    public JT1078_Message_Content_0x0200_AdditionalInformationId(String name, int value, Object since, String description) {
        super(name, value, since, description);
    }
}