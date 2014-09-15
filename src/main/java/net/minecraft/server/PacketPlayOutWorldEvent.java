package net.minecraft.server;

public class PacketPlayOutWorldEvent implements Packet {

   private int a;
   private Location b;
   private int c;
   private boolean d;


   public PacketPlayOutWorldEvent() {}

   public PacketPlayOutWorldEvent(int var1, Location var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readInt();
      this.b = var1.c();
      this.c = var1.readInt();
      this.d = var1.readBoolean();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeInt(this.a);
      var1.a(this.b);
      var1.writeInt(this.c);
      var1.writeBoolean(this.d);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
