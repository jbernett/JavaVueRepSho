<template>
  <div class="foodData">
    <input v-model="searchText" @keyup="searchForIngredients" />
  </div>
</template>
<script>
import api from "./FoodDataApi";

export default {
  name: "FoodData",
  data() {
    return {
      searchText: "",
    };
  },
  created() {},
  methods: {
    getAllIngredients() {
      api.getAll().then(() => {});
    },
    searchForIngredients() {
      if (this.searchText.length > 3) {
        var term = this.searchText;
        api.searchForIngredient(term).then((response) => {
          console.log(response);
        });
      }
    },
  },
};
</script>