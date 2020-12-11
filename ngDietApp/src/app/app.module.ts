import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { EquipmentService } from './services/equipment.service';
import { RecipeService } from './services/recipe.service';
import { FoodService } from './services/food.service';
import { DietService } from './services/diet.service';
import { AllergyService } from './services/allergy.service';
import { AddressService } from './services/address.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FoodListComponent } from './components/food-list/food-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AboutComponent } from './components/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FoodListComponent,
    LoginComponent,
    RegisterComponent,
    NavBarComponent,
    RecipesComponent,
    NotFoundComponent,
    ProfileComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AddressService,
    AllergyService,
    AuthService,
    DietService,
    EquipmentService,
    FoodService,
    RecipeService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
