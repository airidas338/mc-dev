package net.minecraft.server;

public class aqc {

   private ItemStack a;
   private ItemStack b;
   private ItemStack c;
   private int d;
   private int e;
   private boolean f;


   public aqc(NBTTagCompound var1) {
      this.a(var1);
   }

   public aqc(ItemStack var1, ItemStack var2, ItemStack var3) {
      this(var1, var2, var3, 0, 7);
   }

   public aqc(ItemStack var1, ItemStack var2, ItemStack var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = true;
   }

   public aqc(ItemStack var1, ItemStack var2) {
      this(var1, (ItemStack)null, var2);
   }

   public aqc(ItemStack var1, Item var2) {
      this(var1, new ItemStack(var2));
   }

   public ItemStack a() {
      return this.a;
   }

   public ItemStack b() {
      return this.b;
   }

   public boolean c() {
      return this.b != null;
   }

   public ItemStack d() {
      return this.c;
   }

   public int e() {
      return this.d;
   }

   public int f() {
      return this.e;
   }

   public void g() {
      ++this.d;
   }

   public void a(int var1) {
      this.e += var1;
   }

   public boolean h() {
      return this.d >= this.e;
   }

   public boolean j() {
      return this.f;
   }

   public void a(NBTTagCompound var1) {
      NBTTagCompound var2 = var1.getCompound("buy");
      this.a = ItemStack.a(var2);
      NBTTagCompound var3 = var1.getCompound("sell");
      this.c = ItemStack.a(var3);
      if(var1.hasKeyOfType("buyB", 10)) {
         this.b = ItemStack.a(var1.getCompound("buyB"));
      }

      if(var1.hasKeyOfType("uses", 99)) {
         this.d = var1.getInt("uses");
      }

      if(var1.hasKeyOfType("maxUses", 99)) {
         this.e = var1.getInt("maxUses");
      } else {
         this.e = 7;
      }

      if(var1.hasKeyOfType("rewardExp", 1)) {
         this.f = var1.getBoolean("rewardExp");
      } else {
         this.f = true;
      }

   }

   public NBTTagCompound k() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.set("buy", (NBTBase)this.a.b(new NBTTagCompound()));
      var1.set("sell", (NBTBase)this.c.b(new NBTTagCompound()));
      if(this.b != null) {
         var1.set("buyB", (NBTBase)this.b.b(new NBTTagCompound()));
      }

      var1.setInt("uses", this.d);
      var1.setInt("maxUses", this.e);
      var1.setBoolean("rewardExp", this.f);
      return var1;
   }
}
