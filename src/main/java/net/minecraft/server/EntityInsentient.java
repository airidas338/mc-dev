package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class EntityInsentient extends EntityLiving {

   public int a_;
   protected int b_;
   private ControllerLook a;
   protected ControllerMove f;
   protected ControllerJump g;
   private EntityAIBodyControl b;
   protected Navigation h;
   protected final PathfinderGoalSelector goalSelector;
   protected final PathfinderGoalSelector targetSelector;
   private EntityLiving c;
   private EntitySenses bi;
   private ItemStack[] bj = new ItemStack[5];
   protected float[] bh = new float[5];
   private boolean bk;
   private boolean bl;
   private boolean bm;
   private Entity bn;
   private NBTTagCompound bo;


   public EntityInsentient(World var1) {
      super(var1);
      this.goalSelector = new PathfinderGoalSelector(var1 != null && var1.methodProfiler != null?var1.methodProfiler:null);
      this.targetSelector = new PathfinderGoalSelector(var1 != null && var1.methodProfiler != null?var1.methodProfiler:null);
      this.a = new ControllerLook(this);
      this.f = new ControllerMove(this);
      this.g = new ControllerJump(this);
      this.b = new EntityAIBodyControl(this);
      this.h = this.b(var1);
      this.bi = new EntitySenses(this);

      for(int var2 = 0; var2 < this.bh.length; ++var2) {
         this.bh[var2] = 0.085F;
      }

   }

   protected void aW() {
      super.aW();
      this.getAttributeMap().load(GenericAttributes.b).a(16.0D);
   }

   protected Navigation b(World var1) {
      return new aay(this, var1);
   }

   public ControllerLook p() {
      return this.a;
   }

   public ControllerMove q() {
      return this.f;
   }

   public ControllerJump r() {
      return this.g;
   }

   public Navigation getNavigation() {
      return this.h;
   }

   public EntitySenses t() {
      return this.bi;
   }

   public EntityLiving u() {
      return this.c;
   }

   public void d(EntityLiving var1) {
      this.c = var1;
   }

   public boolean a(Class var1) {
      return var1 != EntityGhast.class;
   }

   public void v() {}

   protected void h() {
      super.h();
      this.ac.a(15, Byte.valueOf((byte)0));
   }

   public int w() {
      return 80;
   }

   public void x() {
      String var1 = this.z();
      if(var1 != null) {
         this.a(var1, this.bA(), this.bB());
      }

   }

   public void K() throws IOException {
      super.K();
      this.o.methodProfiler.a("mobBaseTick");
      if(this.isAlive() && this.V.nextInt(1000) < this.a_++) {
         this.a_ = -this.w();
         this.x();
      }

      this.o.methodProfiler.b();
   }

   protected int b(EntityHuman var1) {
      if(this.b_ > 0) {
         int var2 = this.b_;
         ItemStack[] var3 = this.at();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if(var3[var4] != null && this.bh[var4] <= 1.0F) {
               var2 += 1 + this.V.nextInt(3);
            }
         }

         return var2;
      } else {
         return this.b_;
      }
   }

   public void y() {
      if(this.o.isStatic) {
         for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.V.nextGaussian() * 0.02D;
            double var4 = this.V.nextGaussian() * 0.02D;
            double var6 = this.V.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.o.a(ew.a, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var2 * var8, this.t + (double)(this.V.nextFloat() * this.K) - var4 * var8, this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var6 * var8, var2, var4, var6, new int[0]);
         }
      } else {
         this.o.a((Entity)this, (byte)20);
      }

   }

   public void s_() throws IOException {
      super.s_();
      if(!this.o.isStatic) {
         this.bZ();
      }

   }

   protected float h(float var1, float var2) {
      this.b.a();
      return var2;
   }

   protected String z() {
      return null;
   }

   protected Item A() {
      return null;
   }

   protected void b(boolean var1, int var2) {
      Item var3 = this.A();
      if(var3 != null) {
         int var4 = this.V.nextInt(3);
         if(var2 > 0) {
            var4 += this.V.nextInt(var2 + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setBoolean("CanPickUpLoot", this.bX());
      var1.setBoolean("PersistenceRequired", this.bl);
      NBTTagList var2 = new NBTTagList();

      NBTTagCompound var4;
      for(int var3 = 0; var3 < this.bj.length; ++var3) {
         var4 = new NBTTagCompound();
         if(this.bj[var3] != null) {
            this.bj[var3].b(var4);
         }

         var2.a((NBTBase)var4);
      }

      var1.set("Equipment", (NBTBase)var2);
      NBTTagList var6 = new NBTTagList();

      for(int var7 = 0; var7 < this.bh.length; ++var7) {
         var6.a((NBTBase)(new NBTTagFloat(this.bh[var7])));
      }

      var1.set("DropChances", (NBTBase)var6);
      var1.setBoolean("Leashed", this.bm);
      if(this.bn != null) {
         var4 = new NBTTagCompound();
         if(this.bn instanceof EntityLiving) {
            var4.setLong("UUIDMost", this.bn.aJ().getMostSignificantBits());
            var4.setLong("UUIDLeast", this.bn.aJ().getLeastSignificantBits());
         } else if(this.bn instanceof EntityHanging) {
            Location var5 = ((EntityHanging)this.bn).n();
            var4.setInt("X", var5.n());
            var4.setInt("Y", var5.o());
            var4.setInt("Z", var5.p());
         }

         var1.set("Leash", (NBTBase)var4);
      }

      if(this.cd()) {
         var1.setBoolean("NoAI", this.cd());
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("CanPickUpLoot", 1)) {
         this.j(var1.getBoolean("CanPickUpLoot"));
      }

      this.bl = var1.getBoolean("PersistenceRequired");
      NBTTagList var2;
      int var3;
      if(var1.hasKeyOfType("Equipment", 9)) {
         var2 = var1.getList("Equipment", 10);

         for(var3 = 0; var3 < this.bj.length; ++var3) {
            this.bj[var3] = ItemStack.a(var2.b(var3));
         }
      }

      if(var1.hasKeyOfType("DropChances", 9)) {
         var2 = var1.getList("DropChances", 5);

         for(var3 = 0; var3 < var2.c(); ++var3) {
            this.bh[var3] = var2.e(var3);
         }
      }

      this.bm = var1.getBoolean("Leashed");
      if(this.bm && var1.hasKeyOfType("Leash", 10)) {
         this.bo = var1.getCompound("Leash");
      }

      this.k(var1.getBoolean("NoAI"));
   }

   public void m(float var1) {
      this.aY = var1;
   }

   public void j(float var1) {
      super.j(var1);
      this.m(var1);
   }

   public void m() throws IOException {
      super.m();
      this.o.methodProfiler.a("looting");
      if(!this.o.isStatic && this.bX() && !this.aN && this.o.Q().b("mobGriefing")) {
         List var1 = this.o.getEntities(EntityItem.class, this.aQ().b(1.0D, 0.0D, 1.0D));
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            EntityItem var3 = (EntityItem)var2.next();
            if(!var3.I && var3.l() != null && !var3.s()) {
               this.a(var3);
            }
         }
      }

      this.o.methodProfiler.b();
   }

   protected void a(EntityItem var1) {
      ItemStack var2 = var1.l();
      int var3 = c(var2);
      if(var3 > -1) {
         boolean var4 = true;
         ItemStack var5 = this.p(var3);
         if(var5 != null) {
            if(var3 == 0) {
               if(var2.b() instanceof ItemSword && !(var5.b() instanceof ItemSword)) {
                  var4 = true;
               } else if(var2.b() instanceof ItemSword && var5.b() instanceof ItemSword) {
                  ItemSword var6 = (ItemSword)var2.b();
                  ItemSword var7 = (ItemSword)var5.b();
                  if(var6.g() == var7.g()) {
                     var4 = var2.i() > var5.i() || var2.n() && !var5.n();
                  } else {
                     var4 = var6.g() > var7.g();
                  }
               } else if(var2.b() instanceof ItemBow && var5.b() instanceof ItemBow) {
                  var4 = var2.n() && !var5.n();
               } else {
                  var4 = false;
               }
            } else if(var2.b() instanceof ItemArmor && !(var5.b() instanceof ItemArmor)) {
               var4 = true;
            } else if(var2.b() instanceof ItemArmor && var5.b() instanceof ItemArmor) {
               ItemArmor var9 = (ItemArmor)var2.b();
               ItemArmor var10 = (ItemArmor)var5.b();
               if(var9.c == var10.c) {
                  var4 = var2.i() > var5.i() || var2.n() && !var5.n();
               } else {
                  var4 = var9.c > var10.c;
               }
            } else {
               var4 = false;
            }
         }

         if(var4 && this.a(var2)) {
            if(var5 != null && this.V.nextFloat() - 0.1F < this.bh[var3]) {
               this.a(var5, 0.0F);
            }

            if(var2.b() == Items.i && var1.n() != null) {
               EntityHuman var8 = this.o.a(var1.n());
               if(var8 != null) {
                  var8.b((tq)AchievementList.x);
               }
            }

            this.c(var3, var2);
            this.bh[var3] = 2.0F;
            this.bl = true;
            this.a(var1, 1);
            var1.J();
         }
      }

   }

   protected boolean a(ItemStack var1) {
      return true;
   }

   protected boolean C() {
      return true;
   }

   protected void D() {
      if(this.bl) {
         this.aO = 0;
      } else {
         EntityHuman var1 = this.o.a(this, -1.0D);
         if(var1 != null) {
            double var2 = var1.s - this.s;
            double var4 = var1.t - this.t;
            double var6 = var1.u - this.u;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if(this.C() && var8 > 16384.0D) {
               this.J();
            }

            if(this.aO > 600 && this.V.nextInt(800) == 0 && var8 > 1024.0D && this.C()) {
               this.J();
            } else if(var8 < 1024.0D) {
               this.aO = 0;
            }
         }

      }
   }

   protected final void bJ() {
      ++this.aO;
      this.o.methodProfiler.a("checkDespawn");
      this.D();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("sensing");
      this.bi.a();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("targetSelector");
      this.targetSelector.a();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("goalSelector");
      this.goalSelector.a();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("navigation");
      this.h.k();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("mob tick");
      this.E();
      this.o.methodProfiler.b();
      this.o.methodProfiler.a("controls");
      this.o.methodProfiler.a("move");
      this.f.c();
      this.o.methodProfiler.c("look");
      this.a.a();
      this.o.methodProfiler.c("jump");
      this.g.b();
      this.o.methodProfiler.b();
      this.o.methodProfiler.b();
   }

   protected void E() {}

   public int bP() {
      return 40;
   }

   public void a(Entity var1, float var2, float var3) {
      double var4 = var1.s - this.s;
      double var8 = var1.u - this.u;
      double var6;
      if(var1 instanceof EntityLiving) {
         EntityLiving var10 = (EntityLiving)var1;
         var6 = var10.t + (double)var10.aR() - (this.t + (double)this.aR());
      } else {
         var6 = (var1.aQ().b + var1.aQ().e) / 2.0D - (this.t + (double)this.aR());
      }

      double var14 = (double)MathHelper.sqrt(var4 * var4 + var8 * var8);
      float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
      this.z = this.b(this.z, var13, var3);
      this.y = this.b(this.y, var12, var2);
   }

   private float b(float var1, float var2, float var3) {
      float var4 = MathHelper.g(var2 - var1);
      if(var4 > var3) {
         var4 = var3;
      }

      if(var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   public boolean bQ() {
      return true;
   }

   public boolean bR() {
      return this.o.a(this.aQ(), (Entity)this) && this.o.a((Entity)this, this.aQ()).isEmpty() && !this.o.d(this.aQ());
   }

   public int bU() {
      return 4;
   }

   public int aF() {
      if(this.u() == null) {
         return 3;
      } else {
         int var1 = (int)(this.bm() - this.bt() * 0.33F);
         var1 -= (3 - this.o.aa().a()) * 4;
         if(var1 < 0) {
            var1 = 0;
         }

         return var1 + 3;
      }
   }

   public ItemStack bz() {
      return this.bj[0];
   }

   public ItemStack p(int var1) {
      return this.bj[var1];
   }

   public ItemStack q(int var1) {
      return this.bj[var1 + 1];
   }

   public void c(int var1, ItemStack var2) {
      this.bj[var1] = var2;
   }

   public ItemStack[] at() {
      return this.bj;
   }

   protected void a(boolean var1, int var2) {
      for(int var3 = 0; var3 < this.at().length; ++var3) {
         ItemStack var4 = this.p(var3);
         boolean var5 = this.bh[var3] > 1.0F;
         if(var4 != null && (var1 || var5) && this.V.nextFloat() - (float)var2 * 0.01F < this.bh[var3]) {
            if(!var5 && var4.e()) {
               int var6 = Math.max(var4.j() - 25, 1);
               int var7 = var4.j() - this.V.nextInt(this.V.nextInt(var6) + 1);
               if(var7 > var6) {
                  var7 = var6;
               }

               if(var7 < 1) {
                  var7 = 1;
               }

               var4.b(var7);
            }

            this.a(var4, 0.0F);
         }
      }

   }

   protected void a(vu var1) {
      if(this.V.nextFloat() < 0.15F * var1.c()) {
         int var2 = this.V.nextInt(2);
         float var3 = this.o.aa() == EnumDifficulty.HARD?0.1F:0.25F;
         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         for(int var4 = 3; var4 >= 0; --var4) {
            ItemStack var5 = this.q(var4);
            if(var4 < 3 && this.V.nextFloat() < var3) {
               break;
            }

            if(var5 == null) {
               Item var6 = a(var4 + 1, var2);
               if(var6 != null) {
                  this.c(var4 + 1, new ItemStack(var6));
               }
            }
         }
      }

   }

   public static int c(ItemStack var0) {
      if(var0.b() != Item.a(Blocks.PUMPKIN) && var0.b() != Items.bX) {
         if(var0.b() instanceof ItemArmor) {
            switch(((ItemArmor)var0.b()).b) {
            case 0:
               return 4;
            case 1:
               return 3;
            case 2:
               return 2;
            case 3:
               return 1;
            }
         }

         return 0;
      } else {
         return 4;
      }
   }

   public static Item a(int var0, int var1) {
      switch(var0) {
      case 4:
         if(var1 == 0) {
            return Items.Q;
         } else if(var1 == 1) {
            return Items.ag;
         } else if(var1 == 2) {
            return Items.U;
         } else if(var1 == 3) {
            return Items.Y;
         } else if(var1 == 4) {
            return Items.ac;
         }
      case 3:
         if(var1 == 0) {
            return Items.R;
         } else if(var1 == 1) {
            return Items.ah;
         } else if(var1 == 2) {
            return Items.V;
         } else if(var1 == 3) {
            return Items.Z;
         } else if(var1 == 4) {
            return Items.ad;
         }
      case 2:
         if(var1 == 0) {
            return Items.S;
         } else if(var1 == 1) {
            return Items.ai;
         } else if(var1 == 2) {
            return Items.W;
         } else if(var1 == 3) {
            return Items.aa;
         } else if(var1 == 4) {
            return Items.ae;
         }
      case 1:
         if(var1 == 0) {
            return Items.T;
         } else if(var1 == 1) {
            return Items.aj;
         } else if(var1 == 2) {
            return Items.X;
         } else if(var1 == 3) {
            return Items.ab;
         } else if(var1 == 4) {
            return Items.af;
         }
      default:
         return null;
      }
   }

   protected void b(vu var1) {
      float var2 = var1.c();
      if(this.bz() != null && this.V.nextFloat() < 0.25F * var2) {
         EnchantmentManager.a(this.V, this.bz(), (int)(5.0F + var2 * (float)this.V.nextInt(18)));
      }

      for(int var3 = 0; var3 < 4; ++var3) {
         ItemStack var4 = this.q(var3);
         if(var4 != null && this.V.nextFloat() < 0.5F * var2) {
            EnchantmentManager.a(this.V, var4, (int)(5.0F + var2 * (float)this.V.nextInt(18)));
         }
      }

   }

   public xq a(vu var1, xq var2) {
      this.getAttributeInstance(GenericAttributes.b).b(new AttributeModifier("Random spawn bonus", this.V.nextGaussian() * 0.05D, 1));
      return var2;
   }

   public boolean bV() {
      return false;
   }

   public void bW() {
      this.bl = true;
   }

   public void a(int var1, float var2) {
      this.bh[var1] = var2;
   }

   public boolean bX() {
      return this.bk;
   }

   public void j(boolean var1) {
      this.bk = var1;
   }

   public boolean bY() {
      return this.bl;
   }

   public final boolean e(EntityHuman var1) {
      if(this.cb() && this.cc() == var1) {
         this.a(true, !var1.by.canInstantlyBuild);
         return true;
      } else {
         ItemStack var2 = var1.bg.h();
         if(var2 != null && var2.b() == Items.cn && this.ca()) {
            if(!(this instanceof EntityTameableAnimal) || !((EntityTameableAnimal)this).cj()) {
               this.a(var1, true);
               --var2.b;
               return true;
            }

            if(((EntityTameableAnimal)this).e(var1)) {
               this.a(var1, true);
               --var2.b;
               return true;
            }
         }

         return this.a(var1)?true:super.e(var1);
      }
   }

   protected boolean a(EntityHuman var1) {
      return false;
   }

   protected void bZ() {
      if(this.bo != null) {
         this.n();
      }

      if(this.bm) {
         if(!this.isAlive()) {
            this.a(true, true);
         }

         if(this.bn == null || this.bn.I) {
            this.a(true, true);
         }
      }
   }

   public void a(boolean var1, boolean var2) {
      if(this.bm) {
         this.bm = false;
         this.bn = null;
         if(!this.o.isStatic && var2) {
            this.a(Items.cn, 1);
         }

         if(!this.o.isStatic && var1 && this.o instanceof WorldServer) {
            ((WorldServer)this.o).s().a((Entity)this, (Packet)(new ky(1, this, (Entity)null)));
         }
      }

   }

   public boolean ca() {
      return !this.cb() && !(this instanceof IMonster);
   }

   public boolean cb() {
      return this.bm;
   }

   public Entity cc() {
      return this.bn;
   }

   public void a(Entity var1, boolean var2) {
      this.bm = true;
      this.bn = var1;
      if(!this.o.isStatic && var2 && this.o instanceof WorldServer) {
         ((WorldServer)this.o).s().a((Entity)this, (Packet)(new ky(1, this, this.bn)));
      }

   }

   private void n() {
      if(this.bm && this.bo != null) {
         if(this.bo.hasKeyOfType("UUIDMost", 4) && this.bo.hasKeyOfType("UUIDLeast", 4)) {
            UUID var5 = new UUID(this.bo.getLong("UUIDMost"), this.bo.getLong("UUIDLeast"));
            List var6 = this.o.getEntities(EntityLiving.class, this.aQ().b(10.0D, 10.0D, 10.0D));
            Iterator var3 = var6.iterator();

            while(var3.hasNext()) {
               EntityLiving var4 = (EntityLiving)var3.next();
               if(var4.aJ().equals(var5)) {
                  this.bn = var4;
                  break;
               }
            }
         } else if(this.bo.hasKeyOfType("X", 99) && this.bo.hasKeyOfType("Y", 99) && this.bo.hasKeyOfType("Z", 99)) {
            Location var1 = new Location(this.bo.getInt("X"), this.bo.getInt("Y"), this.bo.getInt("Z"));
            EntityLeash var2 = EntityLeash.b(this.o, var1);
            if(var2 == null) {
               var2 = EntityLeash.a(this.o, var1);
            }

            this.bn = var2;
         } else {
            this.a(false, true);
         }
      }

      this.bo = null;
   }

   public boolean d(int var1, ItemStack var2) {
      int var3;
      if(var1 == 99) {
         var3 = 0;
      } else {
         var3 = var1 - 100 + 1;
         if(var3 < 0 || var3 >= this.bj.length) {
            return false;
         }
      }

      if(var2 != null && c(var2) != var3 && (var3 != 4 || !(var2.b() instanceof aju))) {
         return false;
      } else {
         this.c(var3, var2);
         return true;
      }
   }

   public boolean bL() {
      return super.bL() && !this.cd();
   }

   protected void k(boolean var1) {
      this.ac.b(15, Byte.valueOf((byte)(var1?1:0)));
   }

   private boolean cd() {
      return this.ac.a(15) != 0;
   }
}
