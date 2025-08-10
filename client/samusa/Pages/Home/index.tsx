import React from "react";
import { View, StyleSheet } from "react-native";
import UserInput from "./UserInput";

const Home = () => {
  return (
    <View style={styles.container}>
      <UserInput />
    </View>
  );
};

export default Home;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#f5f5f5",
  },
});
