package net.minecraft.server;
import java.util.Comparator;
import java.util.List;

public class ScoreboardScore {

   public static final Comparator a = new bsb();
   private final Scoreboard b;
   private final ScoreboardObjective c;
   private final String d;
   private int e;
   private boolean f;
   private boolean g;


   public ScoreboardScore(Scoreboard var1, ScoreboardObjective var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.g = true;
   }

   public void a(int var1) {
      if(this.c.getCriteria().isReadOnly()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.setScore(this.getScore() + var1);
      }
   }

   public void b(int var1) {
      if(this.c.getCriteria().isReadOnly()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.setScore(this.getScore() - var1);
      }
   }

   public void a() {
      if(this.c.getCriteria().isReadOnly()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.a(1);
      }
   }

   public int getScore() {
      return this.e;
   }

   public void setScore(int var1) {
      int var2 = this.e;
      this.e = var1;
      if(var2 != var1 || this.g) {
         this.g = false;
         this.f().handleScoreChanged(this);
      }

   }

   public ScoreboardObjective d() {
      return this.c;
   }

   public String e() {
      return this.d;
   }

   public Scoreboard f() {
      return this.b;
   }

   public boolean g() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void updateForList(List var1) {
      this.setScore(this.c.getCriteria().a(var1));
   }

}
