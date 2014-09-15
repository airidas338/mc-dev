package net.minecraft.server;

import java.io.IOException;

public interface Packet {

    void a(PacketDataSerializer var1) throws IOException;

    void b(PacketDataSerializer var1) throws IOException;

    void a(PacketListener var1) throws IOException;
}
