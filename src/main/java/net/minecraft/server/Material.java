package net.minecraft.server;

public class Material {

   public static final Material a = new bod(boh.b);
   public static final Material b = new Material(boh.c);
   public static final Material c = new Material(boh.l);
   public static final Material d = (new Material(boh.o)).g();
   public static final Material e = (new Material(boh.m)).f();
   public static final Material f = (new Material(boh.h)).f();
   public static final Material g = (new Material(boh.h)).f().o();
   public static final Material h = (new boe(boh.n)).n();
   public static final Material i = (new boe(boh.f)).n();
   public static final Material j = (new Material(boh.i)).g().s().n();
   public static final Material k = (new boc(boh.i)).n();
   public static final Material l = (new boc(boh.i)).g().n().i();
   public static final Material m = new Material(boh.e);
   public static final Material n = (new Material(boh.e)).g();
   public static final Material o = (new bod(boh.b)).n();
   public static final Material p = new Material(boh.d);
   public static final Material q = (new boc(boh.b)).n();
   public static final Material r = (new boc(boh.e)).g();
   public static final Material s = (new Material(boh.b)).s().p();
   public static final Material t = (new Material(boh.b)).p();
   public static final Material u = (new Material(boh.f)).g().s();
   public static final Material v = (new Material(boh.i)).n();
   public static final Material w = (new Material(boh.g)).s().p();
   public static final Material x = (new Material(boh.g)).p();
   public static final Material y = (new boc(boh.j)).i().s().f().n();
   public static final Material z = (new Material(boh.j)).f();
   public static final Material A = (new Material(boh.i)).s().n();
   public static final Material B = new Material(boh.k);
   public static final Material C = (new Material(boh.i)).n();
   public static final Material D = (new Material(boh.i)).n();
   public static final Material E = (new boi(boh.b)).o();
   public static final Material F = (new Material(boh.b)).n();
   public static final Material G = (new bog(boh.e)).f().n();
   public static final Material H = (new Material(boh.m)).o();
   public static final Material I = (new Material(boh.b)).f().o();
   private boolean J;
   private boolean K;
   private boolean L;
   private final boh M;
   private boolean N = true;
   private int O;
   private boolean P;


   public Material(boh var1) {
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

   public boh r() {
      return this.M;
   }

}
