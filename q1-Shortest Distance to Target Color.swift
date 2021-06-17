// Solution using Dynamic Programming
class Solution {
    func shortestDistanceColor(_ colors: [Int], _ queries: [[Int]]) -> [Int] {
        
        let colorCount = colors.count
        var leftArray = Array(repeating: Array(repeating: -1, count: colorCount), count: 3)
        var rightArray = Array(repeating: Array(repeating: -1, count: colorCount), count: 3)
        
        //Build Left Array
        for color in 0..<3 {
            if colors[0] == color + 1 {
                leftArray[color][0] = 0
            }
            for i in 1..<colorCount {
                let previousColor = leftArray[color][i-1]
                if previousColor != -1 {
                    leftArray[color][i] = previousColor + 1
                }
                if colors[i] == color + 1 {
                    leftArray[color][i] = 0
                }
            }
        }
        
        
        //Build Right Array
        for color in 0..<3 {
            let lastIndex = colorCount - 1
            if colors[lastIndex] == color + 1{
                rightArray[color][lastIndex] = 0
            }
            for i in stride(from: lastIndex - 1, through: 0, by: -1) {
                let previousColor = rightArray[color][i+1]
                if previousColor != -1 {
                    rightArray[color][i] = previousColor + 1
                }
                if colors[i] == color + 1 {
                    rightArray[color][i] = 0
                }
            }
        }
        
        var results = [Int]()
        for query in queries {
            var currentIndex = query[0]
            var color = query[1] - 1
            var leftColor = leftArray[color][currentIndex]
            var rightColor = rightArray[color][currentIndex]
            var result : Int
            if leftColor == -1 || rightColor == -1 {
                result = max(leftColor, rightColor)
            } else {
                result = min(leftColor, rightColor)
            }
            results.append(result)
        }
        return results
    }
}