package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d", &n)
	inp := make([][]int, n)
	for i := 0; i < n; i++ {
		inp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d", &inp[i][j])
		}
	}

	offset := n - 1
	ans := 0
	for i := 0; i < n; i++ {
		for offset >= 0 && inp[i][offset] == 1 {
			offset--
		}
		ans += n - offset - 1
	}

	fmt.Println(ans)
}