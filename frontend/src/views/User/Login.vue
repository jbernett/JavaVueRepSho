<template>
  <div>
    <b-container>
      <b-row>
        <b-col> </b-col>
        <b-col>
          <b-card tag="article" style="max-width: 20rem" class="mb-2">
            <b-card-text>
              <img
                class="welcome-image"
                alt="welcome"
                src="@/assets/welcome.jpg"
              />
              <ValidationObserver v-slot="{ handleSubmit }">
                <form name="form" @submit.prevent="handleSubmit(submit)">
                  <div class="form-group">
                    <label for="username">Username</label>
                    <validation-provider
                      name="field"
                      rules="required|min:3|max:20"
                      v-slot="{ errors }"
                    >
                      <input
                        v-model="user.username"
                        type="text"
                        class="form-control"
                        name="username"
                      />
                      <span>{{ errors[0] }}</span>
                    </validation-provider>
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <validation-provider
                      name="password"
                      rules="required|min:6|max:40"
                      v-slot="{ errors }"
                    >
                      <input
                        v-model="user.password"
                        type="password"
                        class="form-control"
                        name="password"
                      />
                      <span>{{ errors[0] }}</span>
                    </validation-provider>
                  </div>

                  <div class="form-group">
                    <b-btn variant="dark" type="submit" :disabled="loading">
                      <span
                        v-show="loading"
                        class="spinner-border spinner-border-sm"
                      ></span>
                      <span>Login</span>
                    </b-btn>
                  </div>
                </form>
              </ValidationObserver>
            </b-card-text>
            <div>
              <div v-if="message" class="alert alert-danger" role="alert">
                {{ message }}
              </div>
            </div>
          </b-card>
        </b-col>
        <b-col> </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import User from "@/models/user";

export default {
  name: "Login",
  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    submit() {
      this.loading = true;
      if (this.user.username && this.user.password) {
        this.$store.dispatch("auth/login", this.user).then(
          () => {
            this.$router.push("/profile");
          },
          (error) => {
            this.loading = false;
            this.message =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
          }
        );
      }
    },
  },
};
</script>

<style scoped>
.welcome-image {
  max-width: -webkit-fill-available;
  filter: hue-rotate(300deg);
  -webkit-filter: hue-rotate(300deg);
}
.card {
  box-shadow:
  0 2.8px 2.2px rgba(0, 0, 0, 0.034),
  0 6.7px 5.3px rgba(0, 0, 0, 0.048),
  0 12.5px 10px rgba(0, 0, 0, 0.06),
  0 22.3px 17.9px rgba(0, 0, 0, 0.072),
  0 41.8px 33.4px rgba(0, 0, 0, 0.086),
  0 100px 80px rgba(0, 0, 0, 0.12)
}
</style>