package net.minecraft.server;

public class PacketPlayInClientCommand implements Packet {

   private lw a;


   public PacketPlayInClientCommand() {}

   public PacketPlayInClientCommand(lw var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = (lw)var1.a(lw.class);
   }

   public void b(PacketDataSerializer var1) {
      var1.a((Enum)this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public lw a() {
      return this.a;
   }
}
