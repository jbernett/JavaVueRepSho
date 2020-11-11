<template>
  <div class="foodData">
      hello
  </div>
</template>
<script>
import api from "./FoodDataApi";

export default {
  name: "FoodData",
  data() {
    return {};
  },
  created() {
    this.getAllIngredients();
  },
  methods: {
    getAllIngredients() {
      api.getAll().then((response) => {
        console.log(response);
      });
    },
  },
};
</script>