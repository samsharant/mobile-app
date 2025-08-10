import React, { useState } from "react";
import { View, TextInput, Button, StyleSheet } from "react-native";

const UserInput = () => {
  const [inputValue, setInputValue] = useState("");

  const handlePress = () => {
    console.log("User input:", inputValue);
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        value={inputValue}
        onChangeText={setInputValue}
        placeholder="Type here"
      />
      <Button title="Ask AI" onPress={handlePress} />
    </View>
  );
};

export default UserInput;
const styles = StyleSheet.create({
  container: {
    padding: 20,
    width: "90%",
    maxWidth: 400,
  },
  label: {
    fontSize: 18,
    marginBottom: 10,
  },
  input: {
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 6,
    padding: 10,
    marginBottom: 20,
  },
});
