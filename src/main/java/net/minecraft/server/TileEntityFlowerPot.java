package net.minecraft.server;

public class TileEntityFlowerPot extends TileEntity {

   private Item a;
   private int f;


   public TileEntityFlowerPot() {}

   public TileEntityFlowerPot(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      RegistryPrepender var2 = (RegistryPrepender)Item.e.c(this.a);
      var1.setString("Item", var2 == null?"":var2.toString());
      var1.setInt("Data", this.f);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("Item", 8)) {
         this.a = Item.d(var1.getString("Item"));
      } else {
         this.a = Item.b(var1.getInt("Item"));
      }

      this.f = var1.getInt("Data");
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      var1.remove("Item");
      var1.setInt("Item", Item.b(this.a));
      return new PacketPlayOutTileEntityData(this.c, 5, var1);
   }

   public void a(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public Item b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }
}
