<template>
  <div id="app">
    <div class="banner">
      <div v-if="!loggedIn" class="pt-2 pb-2 fr">
        <b-button v-b-hover="handleRegisterHover" to="/register" class="mr-1 ml-2" variant="secondary" size="sm">
            <b-icon v-if="isRegisterHovered" animation="throb" icon="pencil" scale="1.25"></b-icon>
            <b-icon v-else icon="pencil" scale="1"></b-icon>
            Register
        </b-button>
        <b-button v-b-hover="handleSignInHover" to="/login" class="mr-2 ml-1" variant="secondary" size="sm">
            <b-icon v-if="isSignInHovered" animation="throb" icon="person-circle" scale="1.25"></b-icon>
            <b-icon v-else icon="person-circle" scale="1"></b-icon>
            Sign In
        </b-button>
      </div>
    </div>
    <div class="side-banner">
      <Sidebar :isBurgerActive=isBurgerActive v-on:clickedBurger="clickedBurger()"/>  
          <b-button v-b-hover="handleAboutHover" to="/about" class="mt-2 mb-2 ml-0.5" variant="dark" size="sm">
            <b-icon v-if="isAboutHovered" animation="throb" icon="question-circle" scale="1.25"></b-icon>
            <b-icon v-else icon="question-circle" scale="1"></b-icon>
          </b-button>
          <b-button v-b-hover="handleHomeHover" to="/" class="mt-2 mb-2 ml-0.5" variant="dark" size="sm">
            <b-icon v-if="isHomeHovered" animation="throb" icon="house-door-fill" scale="1.5"></b-icon>
            <b-icon v-else icon="house-door-fill" scale="1"></b-icon>
          </b-button>
          <b-button v-b-hover="handleIngredientsHover" to="/ingredients" class="mt-2 mb-2 ml-0.5" variant="dark" size="sm">
            <b-iconstack v-if="isIngredientsHovered">
              <b-icon stacked animation="throb" variant="white" icon="egg-fried" scale="1.5"></b-icon>
              <b-icon stacked icon="dot" variant="warning" scale="2"></b-icon>
            </b-iconstack>
            <b-iconstack v-else>
              <b-icon stacked icon="egg-fried" variant="white" scale="1"></b-icon>
              <b-icon stacked icon="dot" variant="warning" scale="1.5"></b-icon>
            </b-iconstack>
          </b-button>
          <b-button v-b-hover="handleRecipeHover" to="/recipes" class="mt-2 mb-2 ml-0.5" variant="dark" size="sm">
            <b-icon v-if="isRecipeHovered" animation="throb" icon="basket" scale="1.5"></b-icon>
            <b-icon v-else icon="basket" scale="1"></b-icon>
          </b-button>       
    </div>
      <b-container>
            <router-view/>
      </b-container>

  </div>
</template>
<script>
import Sidebar from '@/components/SideNavBar.vue';

export default {  
  components: {
    Sidebar
  },
  data(){
    return {
      isBurgerActive: false,
      isAboutHovered: false,
      isHomeHovered: false,
      isIngredientsHovered: false,
      isRecipeHovered: false,
      isRegisterHovered: false,
      isSignInHovered: false
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  methods: {
    clickedBurger(){
      this.isBurgerActive = !this.isBurgerActive
    },
    handleAboutHover(hovered) {
        this.isAboutHovered = hovered;
    },
    handleHomeHover(hovered){
        this.isHomeHovered = hovered;
    },
    handleIngredientsHover(hovered){
        this.isIngredientsHovered = hovered;
    },
    handleRecipeHover(hovered){
        this.isRecipeHovered = hovered;
    },
    handleRegisterHover(hovered){
      this.isRegisterHovered = hovered;
    },
    handleSignInHover(hovered){
      this.isSignInHovered = hovered
    }
  }
  
}
</script>
<style>
#app {
  font-family: Georgia, sans-serif;;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.btn {
  box-shadow: 0px 3px 1px black, 0 5px 8px darkslategrey;
}

input {
  border: 1px solid darkgray !important;
  box-shadow: 1px 1px lightgrey;
}

.banner {
  width: 100%;
    height: 80px;
    background: linear-gradient(90deg, hotpink 0%, rgb(217, 158, 190) 46%, rgb(244, 238, 240) 100%);
    border-bottom: 2px solid black;
    margin-bottom: 20px;

}
.side-banner {   
  width: 45px;
    top: 0px;
    background: linear-gradient(90deg, rgb(217, 158, 190) 0%, hotpink 100%);
    bottom: 0;
    float: left;
    position: absolute;
    border-right: 2px solid black;
}

.fr{
  float: right;
}

</style>
