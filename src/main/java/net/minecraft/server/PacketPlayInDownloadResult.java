package net.minecraft.server;

public class PacketPlayInDownloadResult implements Packet {

   private String a;
   private EnumDownloadResult b;


   public void a(PacketDataSerializer var1) {
      this.a = var1.c(40);
      this.b = (EnumDownloadResult)var1.a(EnumDownloadResult.class);
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.a((Enum)this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }
}
