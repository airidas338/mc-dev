package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class EntityMinecartHopper extends aed implements IHopper {

   private boolean a = true;
   private int b = -1;
   private Location c;


   public EntityMinecartHopper(World var1) {
      super(var1);
      this.c = Location.a;
   }

   public EntityMinecartHopper(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.c = Location.a;
   }

   public EnumMinecartType s() {
      return EnumMinecartType.HOPPER;
   }

   public IBlockData u() {
      return Blocks.HOPPER.P();
   }

   public int w() {
      return 1;
   }

   public int n_() {
      return 5;
   }

   public boolean e(EntityHuman var1) {
      if(!this.o.isStatic) {
         var1.a((IInventory)this);
      }

      return true;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      boolean var5 = !var4;
      if(var5 != this.y()) {
         this.i(var5);
      }

   }

   public boolean y() {
      return this.a;
   }

   public void i(boolean var1) {
      this.a = var1;
   }

   public World z() {
      return this.o;
   }

   public double A() {
      return this.s;
   }

   public double B() {
      return this.t;
   }

   public double C() {
      return this.u;
   }

   public void s_() throws IOException {
      super.s_();
      if(!this.o.isStatic && this.isAlive() && this.y()) {
         Location var1 = new Location(this);
         if(var1.equals(this.c)) {
            --this.b;
         } else {
            this.m(0);
         }

         if(!this.E()) {
            this.m(0);
            if(this.D()) {
               this.m(4);
               this.o_();
            }
         }
      }

   }

   public boolean D() {
      if(TileEntityHopper.a((IHopper)this)) {
         return true;
      } else {
         List var1 = this.o.getEntities(EntityItem.class, this.aQ().b(0.25D, 0.0D, 0.25D), EntitySelectors.a);
         if(var1.size() > 0) {
            TileEntityHopper.a((IInventory)this, (EntityItem)var1.get(0));
         }

         return false;
      }
   }

   public void a(DamageSource var1) {
      super.a(var1);
      this.a(Item.a((Block)Blocks.HOPPER), 1, 0.0F);
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("TransferCooldown", this.b);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      this.b = var1.getInt("TransferCooldown");
   }

   public void m(int var1) {
      this.b = var1;
   }

   public boolean E() {
      return this.b > 0;
   }

   public String k() {
      return "minecraft:hopper";
   }

   public aib a(ahb var1, EntityHuman var2) {
      return new aix(var1, this, var2);
   }
}
