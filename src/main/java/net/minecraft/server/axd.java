package net.minecraft.server;

public class axd extends TileEntity {

   private ItemStack a;


   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("RecordItem", 10)) {
         this.a(ItemStack.a(var1.getCompound("RecordItem")));
      } else if(var1.getInt("Record") > 0) {
         this.a(new ItemStack(Item.b(var1.getInt("Record")), 1, 0));
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.a() != null) {
         var1.set("RecordItem", (NBTBase)this.a().b(new NBTTagCompound()));
      }

   }

   public ItemStack a() {
      return this.a;
   }

   public void a(ItemStack var1) {
      this.a = var1;
      this.o_();
   }
}
