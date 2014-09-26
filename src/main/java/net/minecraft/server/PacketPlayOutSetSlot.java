package net.minecraft.server;
import java.io.IOException;


public class PacketPlayOutSetSlot implements Packet {

   private int a;
   private int b;
   private ItemStack c;


   public PacketPlayOutSetSlot() {}

   public PacketPlayOutSetSlot(int var1, int var2, ItemStack var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null?null:var3.cloneItemStack();
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.i();
   }

   public void b(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.a(this.c);
   }
}
