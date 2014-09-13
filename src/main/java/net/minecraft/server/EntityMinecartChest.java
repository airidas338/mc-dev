package net.minecraft.server;

public class EntityMinecartChest extends aed {

   public EntityMinecartChest(World var1) {
      super(var1);
   }

   public EntityMinecartChest(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(DamageSource var1) {
      super.a(var1);
      this.a(Item.a((Block)aty.ae), 1, 0.0F);
   }

   public int n_() {
      return 27;
   }

   public EnumMinecartType s() {
      return EnumMinecartType.CHEST;
   }

   public IBlock u() {
      return aty.ae.P().a(BlockChest.a, ej.c);
   }

   public int w() {
      return 8;
   }

   public String k() {
      return "minecraft:chest";
   }

   public aib a(ahb var1, EntityHuman var2) {
      return new aim(var1, this, var2);
   }
}
