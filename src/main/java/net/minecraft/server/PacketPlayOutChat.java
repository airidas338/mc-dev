package net.minecraft.server;

public class PacketPlayOutChat implements Packet {

   private IChatBaseComponent a;
   private byte b;


   public PacketPlayOutChat() {}

   public PacketPlayOutChat(IChatBaseComponent var1) {
      this(var1, (byte)1);
   }

   public PacketPlayOutChat(IChatBaseComponent var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(hd var1) {
      this.a = var1.d();
      this.b = var1.readByte();
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.writeByte(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public boolean b() {
      return this.b == 1 || this.b == 2;
   }
}
