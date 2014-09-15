package net.minecraft.server;
import java.io.IOException;


public class PacketPlayInSetCreativeSlot implements Packet {

   private int a;
   private ItemStack b;


   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) throws IOException {
      this.a = var1.readShort();
      this.b = var1.i();
   }

   public void b(PacketDataSerializer var1) throws IOException {
      var1.writeShort(this.a);
      var1.a(this.b);
   }

   public int a() {
      return this.a;
   }

   public ItemStack b() {
      return this.b;
   }
}
