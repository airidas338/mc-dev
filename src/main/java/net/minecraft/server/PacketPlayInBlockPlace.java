package net.minecraft.server;
import java.io.IOException;


public class PacketPlayInBlockPlace implements Packet {

   private static final Location a = new Location(-1, -1, -1);
   private Location b;
   private int c;
   private ItemStack d;
   private float e;
   private float f;
   private float g;


   public PacketPlayInBlockPlace() {}

   public PacketPlayInBlockPlace(ItemStack var1) {
      this(a, 255, var1, 0.0F, 0.0F, 0.0F);
   }

   public PacketPlayInBlockPlace(Location var1, int var2, ItemStack var3, float var4, float var5, float var6) {
      this.b = var1;
      this.c = var2;
      this.d = var3 != null?var3.cloneItemStack():null;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   public void a(PacketDataSerializer var1) throws IOException {
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
      this.d = var1.i();
      this.e = (float)var1.readUnsignedByte() / 16.0F;
      this.f = (float)var1.readUnsignedByte() / 16.0F;
      this.g = (float)var1.readUnsignedByte() / 16.0F;
   }

   public void b(PacketDataSerializer var1) throws IOException {
      var1.a(this.b);
      var1.writeByte(this.c);
      var1.a(this.d);
      var1.writeByte((int)(this.e * 16.0F));
      var1.writeByte((int)(this.f * 16.0F));
      var1.writeByte((int)(this.g * 16.0F));
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public Location a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public ItemStack c() {
      return this.d;
   }

   public float d() {
      return this.e;
   }

   public float e() {
      return this.f;
   }

   public float f() {
      return this.g;
   }

}
