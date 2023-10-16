<template>
  <div>
    <h2>Login</h2>
    <p>Click the button below to authenticate via Google:</p>
    <a :href="googleAuthURL">
      <button>Login with Google</button>
    </a>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      googleAuthURL: ''
    }
  },
  async mounted() {
    try {
      const response = await axios.get('/api/login');
      this.googleAuthURL = response.data.googleAuthURL;
    } catch (error) {
      console.error("Error fetching the Google auth URL", error);
    }
  }
}
</script>
