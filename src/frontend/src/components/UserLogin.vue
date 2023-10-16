<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="usernameOrEmail">usernameOrEmail:</label>
        <input v-model="credentials.usernameOrEmail" id="usernameOrEmail" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" v-model="credentials.password" id="password" required />
      </div>
      <div>
        <button type="submit">Login</button>
      </div>
    </form>
    <p v-if="error" class="error-text">{{ error }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      credentials: {
        usernameOrEmail: '',
        password: ''
      },
      error: null,
    };
  },
  methods: {
    async login() {
      try {
        // Send a POST request to your API endpoint
        const response = await axios.post('/api/auth/login', this.credentials)

        // Check if the API responded with an access token
        if (response.data && response.data.accessToken) {
          // Store the access token securely, e.g., in HTTPOnly cookie or Vuex state
          console.log(response.data.accessToken)
          // Redirect user to the Home page
          this.$router.push({ path: '/home' })
        } else {
          // If the API response does not contain an access token, show an error
          this.error = 'Invalid login credentials, please try again.'
        }
      } catch (error) {
        // Handle error: if the API responded with a status code outside the 2xx range
        console.error('Error during login:', error)
        this.error = 'Invalid login credentials, please try again.'
      }
    }
  }
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: auto;
  text-align: left;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
}

button {
  padding: 10px 15px;
}

.error-text {
  color: red;
  margin-top: 15px;
}
</style>
