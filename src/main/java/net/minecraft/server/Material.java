package net.minecraft.server;

public class Material {

   public static final Material AIR = new bod(MaterialMapColor.b);
   public static final Material GRASS = new Material(MaterialMapColor.c);
   public static final Material EARTH = new Material(MaterialMapColor.l);
   public static final Material WOOD = (new Material(MaterialMapColor.o)).g();
   public static final Material STONE = (new Material(MaterialMapColor.m)).f();
   public static final Material ORE = (new Material(MaterialMapColor.h)).f();
   public static final Material HEAVY = (new Material(MaterialMapColor.h)).f().o();
   public static final Material WATER = (new boe(MaterialMapColor.n)).n();
   public static final Material LAVA = (new boe(MaterialMapColor.f)).n();
   public static final Material LEAVES = (new Material(MaterialMapColor.i)).g().s().n();
   public static final Material PLANT = (new boc(MaterialMapColor.i)).n();
   public static final Material REPLACAEBLE_PLAN = (new boc(MaterialMapColor.i)).g().n().i();
   public static final Material SPONGE = new Material(MaterialMapColor.e);
   public static final Material CLOTH = (new Material(MaterialMapColor.e)).g();
   public static final Material FIRE = (new bod(MaterialMapColor.b)).n();
   public static final Material SAND = new Material(MaterialMapColor.d);
   public static final Material ORIENTABLE = (new boc(MaterialMapColor.b)).n();
   public static final Material WOOL = (new boc(MaterialMapColor.e)).g();
   public static final Material SHATTERABLE = (new Material(MaterialMapColor.b)).s().p();
   public static final Material BUILDABLE_GLASS = (new Material(MaterialMapColor.b)).p();
   public static final Material TNT = (new Material(MaterialMapColor.f)).g().s();
   public static final Material CORAL = (new Material(MaterialMapColor.i)).n();
   public static final Material ICE = (new Material(MaterialMapColor.g)).s().p();
   public static final Material SNOW_LAYER = (new Material(MaterialMapColor.g)).p();
   public static final Material PACKED_ICE = (new boc(MaterialMapColor.j)).i().s().f().n();
   public static final Material SNOW_BLOCK = (new Material(MaterialMapColor.j)).f();
   public static final Material CACTUS = (new Material(MaterialMapColor.i)).s().n();
   public static final Material CLAY = new Material(MaterialMapColor.k);
   public static final Material PUMPKIN = (new Material(MaterialMapColor.i)).n();
   public static final Material DRAGON_EGG = (new Material(MaterialMapColor.i)).n();
   public static final Material PORTAL = (new boi(MaterialMapColor.b)).o();
   public static final Material CAKE = (new Material(MaterialMapColor.b)).n();
   public static final Material WEB = (new bog(MaterialMapColor.e)).f().n();
   public static final Material PISTON = (new Material(MaterialMapColor.m)).o();
   public static final Material BARRIER = (new Material(MaterialMapColor.b)).f().o();
   private boolean J;
   private boolean K;
   private boolean L;
   private final MaterialMapColor M;
   private boolean N = true;
   private int O;
   private boolean P;


   public Material(MaterialMapColor var1) {
      this.M = var1;
   }

   public boolean d() {
      return false;
   }

   public boolean a() {
      return true;
   }

   public boolean b() {
      return true;
   }

   public boolean c() {
      return true;
   }

   private Material s() {
      this.L = true;
      return this;
   }

   protected Material f() {
      this.N = false;
      return this;
   }

   protected Material g() {
      this.J = true;
      return this;
   }

   public boolean h() {
      return this.J;
   }

   public Material i() {
      this.K = true;
      return this;
   }

   public boolean j() {
      return this.K;
   }

   public boolean k() {
      return this.L?false:this.c();
   }

   public boolean l() {
      return this.N;
   }

   public int m() {
      return this.O;
   }

   protected Material n() {
      this.O = 1;
      return this;
   }

   protected Material o() {
      this.O = 2;
      return this;
   }

   protected Material p() {
      this.P = true;
      return this;
   }

   public MaterialMapColor r() {
      return this.M;
   }

}
